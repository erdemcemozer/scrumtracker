<template>
    <div class="text-center">
        <v-dialog v-model="dialog" width="500" @click:outside="$emit('add-task', false)">
            <template #activator="{ on, attrs }">

                <v-btn class="neumerophism"
                       text rounded height="40" block
                       v-bind="attrs"
                       v-on="on">

                    <v-icon v-text="'mdi-bullhorn-outline'" class="mr-2"/>
                    {{ $t('addAnnouncement') }}
                </v-btn>

            </template>

            <v-card class="pa-10">

                <h3 class="mb-6 text-center" v-text="$t('addAnnouncementTitle')"/>

                <v-row justify="center">

                    <v-col cols="12">
                        <v-text-field v-model="form.issueTitle"
                                      :label="$t('announcementTitle')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-bullhorn-outline"/>
                    </v-col>

                    <v-col cols="12">
                        <v-text-field v-model="form.issueDesc"
                                      :label="$t('description')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-bullhorn-outline"/>
                    </v-col>

                    <v-col cols="12">
                        <v-text-field v-model="form.issueType"
                                      :label="$t('issueType')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-comment-text-outline"/>
                    </v-col>

                    <v-col cols="12">
                        <v-text-field v-model="form.issueSprintName"
                                      :label="$t('issueSprintName')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-comment-text-outline"/>
                    </v-col>

                    <v-col cols="12">
                        <v-select
                            v-model="form.issuePriority"
                            :items="issuePriorityItems"
                            outlined dense rounded
                            label="Issue Priority"
                        />
                    </v-col>

                    <v-col cols="12">
                        <v-text-field v-model="form.issueEstimation"
                                      :label="$t('issueType')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-comment-text-outline"/>
                    </v-col>

                    <v-col cols="12">
                        <v-select
                            v-model="form.issueStatus"
                            :items="issueStatusItems"
                            outlined dense rounded
                            label="Issue Status"
                        />
                    </v-col>

                    <v-col cols="12">
                        <v-select
                            v-model="form.issueOwner"
                            :items="issueOwnerItems"
                            outlined dense rounded
                            label="Issue Owner"
                        />
                    </v-col>


                    <div class="d-flex justify-end mt-2">
                        <v-btn rounded depressed block
                               color="primary" type="submit" @click.prevent="submit" class="px-10">
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
    name: "ProductBacklogDialog",
    props: {
        open: {
            default: false,
            type: Boolean
        },
        formEdit: {
            default: null,
            type: Object
        }
    },
    data(){
        return {
            dialog: false,
            form: {
                issueTitle: null,
                issueDesc: null,
                issueType: null,
                issueSprintName: null,
                issuePriority: null,  // dropdown
                issueEstimation: null,
                issueStatus: null, // dropdown -> bug, story, task, feature, improvement, epic
                issueOwner: null // databaseden dropdown
            },
            issueStatusItems: ['bug', 'story', 'task', 'feature', 'improvement', 'epic'],
            issuePriorityItems: ['blocker', 'critical', 'major', 'normal', 'minor'],
            issueOwnerItems: []
        }
    },
    methods:{
        async submit(){

            /*if(this.form?.announcementId){
                await this.$store.dispatch('POST_ANNOUNCEMENTS_UPDATE', this.form).then(()=>{
                    this.$nuxt.refresh()
                })
            }else {
                await this.$store.dispatch('POST_ANNOUNCEMENTS_ADD', this.form).then(()=>{
                    this.$nuxt.refresh()
                })
            }*/

            this.$emit('add-task', false)
            this.dialog = false

        },
    },
    watch:{
        open(val){
            if(val === true){
                this.dialog = true
            }else {
                this.dialog = false
            }
        },
        formEdit: {
            handler(val) {
                console.log('formedit',val)
                this.form = {
                    ...val
                }

            },
            deep: true
        }
    },
    async created() {
        await this.$store.dispatch('GET_USERS').then(()=>{
              console.log('users', this.$store.state.users)
               let items = this.$store.state.users
                for(let item of items) {
                    this.issueOwnerItems.push(item.name)
                    //this.issueOwnerItems.push(item.id)
                }
                // console.log('issue2', this.issueOwnerItems)
            }
        )
    }
}
</script>

