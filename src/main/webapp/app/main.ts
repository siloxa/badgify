import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

import App from './app.vue';
import Vue2Filters from 'vue2-filters';
import { ToastPlugin } from 'bootstrap-vue';
import router from './router';
import * as config from './shared/config/config';
import * as bootstrapVueConfig from './shared/config/config-bootstrap-vue';
import JhiItemCountComponent from './shared/jhi-item-count.vue';
import JhiSortIndicatorComponent from './shared/sort/jhi-sort-indicator.vue';
import InfiniteLoading from 'vue-infinite-loading';
import AlertService from './shared/alert/alert.service';

import '../content/scss/global.scss';
import '../content/scss/vendor.scss';

Vue.config.productionTip = false;
config.initVueApp(Vue);
config.initFortAwesome(Vue);
bootstrapVueConfig.initBootstrapVue(Vue);
Vue.use(Vue2Filters);
Vue.use(ToastPlugin);
Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.component('jhi-item-count', JhiItemCountComponent);
Vue.component('jhi-sort-indicator', JhiSortIndicatorComponent);
Vue.component('infinite-loading', InfiniteLoading);

router.beforeEach(async (to, from, next) => {
  if (!to.matched.length) {
    next('/not-found');
  } else if (to.meta && to.meta.authorities && to.meta.authorities.length > 0) {

  } else {
    next();
  }
});

const vue = new Vue({
  el: '#app',
  components: { App },
  template: '<App/>',
  router,
  provide: {
    alertService: () => new AlertService(),
  },
});
