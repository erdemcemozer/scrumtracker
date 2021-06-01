<template>
    <div class="text-center">
        <v-dialog v-model="dialog" width="500" @click:outside="$emit('add-task', false)">
            <template #activator="{ on, attrs }">

                <v-btn class="neumerophism"
                       text rounded height="40" block
                       v-bind="attrs"
                       v-on="on">

                    <v-icon v-text="'mdi-flag-plus-outline'" class="mr-2"/>
                    {{ $t('addIssue') }}
                </v-btn>

            </template>

            <v-card class="pa-10">

                <h3 class="mb-6 text-center" v-text="$t('pleaseAddNecessaryInformation')"/>

                <v-row justify="center">

                    <v-col cols="12">
                        <v-text-field v-model="form.issueTitle"
                                      :label="$t('title')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-format-title"/>
                    </v-col>

                    <v-col cols="12">
                        <v-text-field v-model="form.issueDesc"
                                      :label="$t('description')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-comment-text-outline"/>
                    </v-col>

                    <v-col cols="12">
                        <v-select
                            v-model="form.issueType"
                            :items="issueTypeItems"
                            outlined dense rounded
                            :label="$t('issueType')+':'"
                            prepend-inner-icon="mdi-format-list-bulleted-type" />
                    </v-col>

                    <v-col cols="12">
                        <v-select
                            v-model="form.issueSprintName"
                            :items="issueSprintNameItems"
                            outlined dense rounded
                            :label="$t('sprintName')+':'"
                            item-text="sprintName"
                            item-value="sprintName"
                            prepend-inner-icon="mdi-alpha-n-box-outline" />
                    </v-col>

                    <v-col cols="12">
                        <v-select
                            v-model="form.issuePriority"
                            :items="issuePriorityItems"
                            outlined dense rounded
                            :label="$t('priority')+':'"
                            prepend-inner-icon="mdi-priority-high"/>
                    </v-col>

                    <v-col cols="12">
                        <v-text-field v-model="form.issueEstimation"
                                      :label="$t('estimation')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-counter"/>
                    </v-col>

                    <v-col cols="12">
                        <v-select
                            v-model="form.issueStatus"
                            :items="issueStatusItems"
                            outlined dense rounded
                            :label="$t('status')+':'"
                            prepend-inner-icon="mdi-list-status"/>
                    </v-col>

                    <v-col cols="12">
                        <v-select
                            v-model="form.issueOwner"
                            :items="issueOwnerItems"
                            outlined dense rounded
                            :label="$t('owner')+':'"
                            prepend-inner-icon="mdi-account-question-outline" />
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
        },
    },
    data(){
        return {
            dialog: false,
            form: {
                issueTitle: null,
                issueDesc: null,
                issueType: null, //['bug', 'story', 'task', 'feature', 'improvement', 'epic'],
                issueSprintName: null,
                issuePriority: null,  // dropdown
                issueEstimation: null,
                issueStatus: null, // ['Done', 'Reopen', 'In Progress', 'In Test', this.$t('minor')],
                issueOwner: null // databaseden dropdown
            },
            issueStatusItems: ['Done', 'Reopen', 'In Progress', 'In Test', 'Resolved'],
            issueTypeItems: ['bug', 'story', 'task', 'feature', 'improvement', 'epic'],
            issuePriorityItems: [this.$t('blocker'), this.$t('critical'), this.$t('major'), this.$t('normal'), this.$t('minor')],
            issueOwnerItems: [],
            issueSprintNameItems: []
        }
    },
    methods:{
        async submit(){

            if(this.form?.id){
                await this.$store.dispatch('POST_UPDATE_ISSUE', this.form).then(()=>{
                    this.$nuxt.refresh()
                })
            }else {
                await this.$store.dispatch('POST_CREATE_ISSUE', this.form).then(()=>{
                    this.$nuxt.refresh()
                })
            }

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
        },
       /* dialog(val) {
            if(!val){
                this.form = {
                    issueTitle: null,
                    issueDesc: null,
                    issueType: null,
                    issueSprintName: null,
                    issuePriority: null,
                    issueEstimation: null,
                    issueStatus: null,
                    issueOwner: null
                }
            }
        }*/
    },
    async created() {
        await this.$store.dispatch('GET_USERS').then(()=>{
              console.log('users', this.$store.state.users)
               let items = this.$store.state.users
                for(let item of items) {
                    this.issueOwnerItems.push(item.name + ' ' + item.surname)
                    //this.issueOwnerItems.push(item.id)
                }

                // console.log('issue2', this.issueOwnerItems)
            }
        )
        this.$store.dispatch('GET_ALL_SPRINTS').then(()=>{
            this.issueSprintNameItems = this.$store.state.allSprints
        })
    },

}
</script>

