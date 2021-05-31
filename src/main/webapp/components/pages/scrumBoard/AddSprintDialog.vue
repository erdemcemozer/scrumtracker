<template>
    <div class="text-center">
        <v-dialog v-model="dialog" width="500">
            <template v-slot:activator="{ on, attrs }">

                <v-btn color="" dense v-bind="attrs" v-on="on">
                    Add Sprint
                </v-btn>

            </template>

            <v-card class="pa-10">

                <h3 class="mb-6 text-center" v-text="$t('addAnnouncementTitle')"/>

                <v-row justify="center">
                    <v-col cols="12">
                        <v-text-field v-model="form.sprintName"
                                      :label="$t('announcementTitle')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-bullhorn-outline"/>

                    </v-col>
                    <v-col cols="12">

                        <v-text-field v-model="form.sprintDesc"
                                      :label="$t('description')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-comment-text-outline"/>

                    </v-col>

                    <div class="d-flex justify-end mt-2">
                        <v-btn rounded depressed block color="primary" type="submit" @click.prevent="addTask" class="px-10">
                            {{ $t('add') }}
                        </v-btn>
                    </div>

                </v-row>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
export default {
    data () {
        return {
            dialog: false,
            form: {
                sprintName: null,
                sprintDesc: null
            }
        }
    },
    methods: {
        async addTask() {
            this.dialog = false
            await this.$store.dispatch('POST_CREATE_SPRINT',this.form)
        }
    }
}
</script>
