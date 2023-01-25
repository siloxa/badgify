import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import UserService from '@/entities/user/user.service';

import { IBadge, Badge } from '@/shared/model/badge.model';
import BadgeService from './badge.service';

const validations: any = {
  badge: {
    badge: {},
    count: {},
  },
};

@Component({
  validations,
})
export default class BadgeUpdate extends Vue {
  @Inject('badgeService') private badgeService: () => BadgeService;
  @Inject('alertService') private alertService: () => AlertService;

  public badge: IBadge = new Badge();

  @Inject('userService') private userService: () => UserService;

  public users: Array<any> = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.badgeId) {
        vm.retrieveBadge(to.params.badgeId);
      }
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.badge.id) {
      this.badgeService()
        .update(this.badge)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = 'A Badge is updated with identifier ' + param.id;
          return (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    } else {
      this.badgeService()
        .create(this.badge)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = 'A Badge is created with identifier ' + param.id;
          (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    }
  }

  public retrieveBadge(badgeId): void {
    this.badgeService()
      .find(badgeId)
      .then(res => {
        this.badge = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.userService()
      .retrieve()
      .then(res => {
        this.users = res.data;
      });
  }
}
