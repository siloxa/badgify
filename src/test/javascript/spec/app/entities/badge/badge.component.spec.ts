/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import BadgeComponent from '@/entities/badge/badge.vue';
import BadgeClass from '@/entities/badge/badge.component';
import BadgeService from '@/entities/badge/badge.service';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(ToastPlugin);

config.initVueApp(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Badge Management Component', () => {
    let wrapper: Wrapper<BadgeClass>;
    let comp: BadgeClass;
    let badgeServiceStub: SinonStubbedInstance<BadgeService>;

    beforeEach(() => {
      badgeServiceStub = sinon.createStubInstance<BadgeService>(BadgeService);
      badgeServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<BadgeClass>(BadgeComponent, {
        store,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          badgeService: () => badgeServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      badgeServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '9fec3727-3421-4967-b213-ba36557ca194' }] });

      // WHEN
      comp.retrieveAllBadges();
      await comp.$nextTick();

      // THEN
      expect(badgeServiceStub.retrieve.called).toBeTruthy();
      expect(comp.badges[0]).toEqual(expect.objectContaining({ id: '9fec3727-3421-4967-b213-ba36557ca194' }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      badgeServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: '9fec3727-3421-4967-b213-ba36557ca194' });
      expect(badgeServiceStub.retrieve.callCount).toEqual(1);

      comp.removeBadge();
      await comp.$nextTick();

      // THEN
      expect(badgeServiceStub.delete.called).toBeTruthy();
      expect(badgeServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
