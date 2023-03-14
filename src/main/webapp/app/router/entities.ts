import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore
const Entities = () => import('@/entities/entities.vue');

// prettier-ignore
const Badge = () => import('@/entities/badge/badge.vue');
// prettier-ignore
const BadgeUpdate = () => import('@/entities/badge/badge-update.vue');
// prettier-ignore
const BadgeDetails = () => import('@/entities/badge/badge-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/',
  component: Entities,
  children: [
    {
      path: 'badge',
      name: 'Badge',
      component: Badge,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'badge/new',
      name: 'BadgeCreate',
      component: BadgeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'badge/:badgeId/edit',
      name: 'BadgeEdit',
      component: BadgeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'badge/:badgeId/view',
      name: 'BadgeView',
      component: BadgeDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
