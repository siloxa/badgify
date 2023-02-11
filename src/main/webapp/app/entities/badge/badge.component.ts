import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IBadge } from '@/shared/model/badge.model';

import BadgeService from './badge.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Badge extends Vue {
  @Inject('badgeService') private badgeService: () => BadgeService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: string = null;

  public badges: IBadge[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllBadges();
  }

  public clear(): void {
    this.retrieveAllBadges();
  }

  public retrieveAllBadges(): void {
    this.isFetching = true;
    this.badgeService()
      .retrieve()
      .then(
        res => {
          this.badges = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
          this.alertService().showHttpError(this, err.response);
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IBadge): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeBadge(): void {
    this.badgeService()
      .delete(this.removeId)
      .then(() => {
        const message = 'A Badge is deleted with identifier ' + this.removeId;
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllBadges();
        this.closeDialog();
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
