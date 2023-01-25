/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import BadgeDetailComponent from '@/entities/badge/badge-details.vue';
import BadgeClass from '@/entities/badge/badge-details.component';
import BadgeService from '@/entities/badge/badge.service';
import router from '@/router';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Badge Management Detail Component', () => {
    let wrapper: Wrapper<BadgeClass>;
    let comp: BadgeClass;
    let badgeServiceStub: SinonStubbedInstance<BadgeService>;

    beforeEach(() => {
      badgeServiceStub = sinon.createStubInstance<BadgeService>(BadgeService);

      wrapper = shallowMount<BadgeClass>(BadgeDetailComponent, {
        store,
        localVue,
        router,
        provide: { badgeService: () => badgeServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundBadge = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        badgeServiceStub.find.resolves(foundBadge);

        // WHEN
        comp.retrieveBadge('9fec3727-3421-4967-b213-ba36557ca194');
        await comp.$nextTick();

        // THEN
        expect(comp.badge).toBe(foundBadge);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundBadge = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        badgeServiceStub.find.resolves(foundBadge);

        // WHEN
        comp.beforeRouteEnter({ params: { badgeId: '9fec3727-3421-4967-b213-ba36557ca194' } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.badge).toBe(foundBadge);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
