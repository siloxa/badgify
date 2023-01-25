<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="badge">
        <h2 class="jh-entity-heading" data-cy="badgeDetailsHeading"><span>Badge</span> {{ badge.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Badge</span>
          </dt>
          <dd>
            <span>{{ badge.badge }}</span>
          </dd>
          <dt>
            <span>Count</span>
          </dt>
          <dd>
            <span>{{ badge.count }}</span>
          </dd>
          <dt>
            <span>User</span>
          </dt>
          <dd>
            {{ badge.user ? badge.user.id : '' }}
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span> Back</span>
        </button>
        <router-link v-if="badge.id" :to="{ name: 'BadgeEdit', params: { badgeId: badge.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./badge-details.component.ts"></script>
