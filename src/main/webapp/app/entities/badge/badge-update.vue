<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="badgifyApp.badge.home.createOrEditLabel" data-cy="BadgeCreateUpdateHeading">Create or edit a Badge</h2>
        <div>
          <div class="form-group" v-if="badge.id">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="badge.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="badge-badge">Badge</label>
            <input
              type="text"
              class="form-control"
              name="badge"
              id="badge-badge"
              data-cy="badge"
              :class="{ valid: !$v.badge.badge.$invalid, invalid: $v.badge.badge.$invalid }"
              v-model="$v.badge.badge.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="badge-badgeType">Badge Type</label>
            <select
              class="form-control"
              name="badgeType"
              :class="{ valid: !$v.badge.badgeType.$invalid, invalid: $v.badge.badgeType.$invalid }"
              v-model="$v.badge.badgeType.$model"
              id="badge-badgeType"
              data-cy="badgeType"
            >
              <option v-for="badgeType in badgeTypeValues" :key="badgeType" v-bind:value="badgeType">{{ badgeType }}</option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="badge-count">Count</label>
            <input
              type="number"
              class="form-control"
              name="count"
              id="badge-count"
              data-cy="count"
              :class="{ valid: !$v.badge.count.$invalid, invalid: $v.badge.count.$invalid }"
              v-model.number="$v.badge.count.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="badge-user">User</label>
            <select class="form-control" id="badge-user" data-cy="user" name="user" v-model="badge.user">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="badge.user && userOption.id === badge.user.id ? badge.user : userOption"
                v-for="userOption in users"
                :key="userOption.id"
              >
                {{ userOption.id }}
              </option>
            </select>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span>Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.badge.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span>Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./badge-update.component.ts"></script>
