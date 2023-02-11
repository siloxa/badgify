import { Component, Vue, Inject } from 'vue-property-decorator';

import { IBadge } from '@/shared/model/badge.model';
import BadgeService from './badge.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class BadgeDetails extends Vue {
  @Inject('badgeService') private badgeService: () => BadgeService;
  @Inject('alertService') private alertService: () => AlertService;

  public badge: IBadge = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.badgeId) {
        vm.retrieveBadge(to.params.badgeId);
      }
    });
  }

  public retrieveBadge(badgeId) {
    this.badgeService()
      .find(badgeId)
      .then(res => {
        this.badge = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
