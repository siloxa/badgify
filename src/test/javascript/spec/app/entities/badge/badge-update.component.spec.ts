/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import BadgeUpdateComponent from '@/entities/badge/badge-update.vue';
import BadgeClass from '@/entities/badge/badge-update.component';
import BadgeService from '@/entities/badge/badge.service';

import UserService from '@/entities/user/user.service';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.use(ToastPlugin);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('Badge Management Update Component', () => {
    let wrapper: Wrapper<BadgeClass>;
    let comp: BadgeClass;
    let badgeServiceStub: SinonStubbedInstance<BadgeService>;

    beforeEach(() => {
      badgeServiceStub = sinon.createStubInstance<BadgeService>(BadgeService);

      wrapper = shallowMount<BadgeClass>(BadgeUpdateComponent, {
        store,
        localVue,
        router,
        provide: {
          badgeService: () => badgeServiceStub,
          alertService: () => new AlertService(),

          userService: () => new UserService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        comp.badge = entity;
        badgeServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(badgeServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.badge = entity;
        badgeServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(badgeServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundBadge = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        badgeServiceStub.find.resolves(foundBadge);
        badgeServiceStub.retrieve.resolves([foundBadge]);

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
