<template>
  <div>
    <h2 id="page-heading" data-cy="BadgeHeading">
      <span id="badge-heading">Badges</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Refresh List</span>
        </button>
        <router-link :to="{ name: 'BadgeCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-badge"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span> Create a new Badge </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && badges && badges.length === 0">
      <span>No badges found</span>
    </div>
    <div class="table-responsive" v-if="badges && badges.length > 0">
      <table class="table table-striped" aria-describedby="badges">
        <thead>
          <tr>
            <th scope="row"><span>ID</span></th>
            <th scope="row"><span>Badge</span></th>
            <th scope="row"><span>Count</span></th>
            <th scope="row"><span>User</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="badge in badges" :key="badge.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'BadgeView', params: { badgeId: badge.id } }">{{ badge.id }}</router-link>
            </td>
            <td>{{ badge.badge }}</td>
            <td>{{ badge.count }}</td>
            <td>
              {{ badge.user ? badge.user.id : '' }}
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'BadgeView', params: { badgeId: badge.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'BadgeEdit', params: { badgeId: badge.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(badge)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="badgifyApp.badge.delete.question" data-cy="badgeDeleteDialogHeading">Confirm delete operation</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-badge-heading">Are you sure you want to delete this Badge?</p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-badge"
          data-cy="entityConfirmDeleteButton"
          v-on:click="removeBadge()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./badge.component.ts"></script>
