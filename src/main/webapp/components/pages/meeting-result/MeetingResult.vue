<template>
    <div>
        <v-container>
            <v-row>
                <v-col cols="12" md="6">
                    <v-card tile flat color="transparent">
                        <v-row>
                            <v-col cols="12" class="d-flex justify-space-between align-center pt-2 px-10">
                                <h4 class="text-h6">{{ $t('review') }}</h4>
                                <v-btn icon @click="addResult('review')">
                                    <v-icon size="30" v-text="'mdi-plus-circle-outline'"/>
                                </v-btn>
                            </v-col>
                            <v-col cols="12" class="px-5">
                                <v-divider class="my-3"></v-divider>
                            </v-col>

                            <v-col cols="12" class="mt-3 px-5">
                                <v-card class="mb-4 pa-4" v-for="(item, i) in openReview" :key="`${item.title}-${i}`">
                                    <div  class="d-flex justify-space-between align-center mb-2">
                                        <h4>{{ item.title }}</h4>

                                            <template>
                                                <div class="d-flex">
                                                            <v-btn icon color="grey" @click="edit(item)">
                                                                <v-icon size="24" v-text="'mdi-pencil'"/>
                                                            </v-btn>

                                                            <v-btn icon color="grey" class="ml-3"  @click="deleteResult(item)">
                                                                <v-icon size="24" v-text="'mdi-delete-outline'"/>
                                                            </v-btn>
                                                </div>
                                            </template>
                                    </div>

                                    <p>{{ item.description }}</p>
                                </v-card>
                            </v-col>
                        </v-row>

                    </v-card>
                </v-col>

                <v-col cols="12" md="6">
                    <v-card tile flat color="transparent">
                        <v-row>
                            <v-col cols="12" class="d-flex justify-space-between align-center pt-2 px-10">
                                <h4 class="text-h6">{{ $t('retrospective') }}</h4>
                                <v-btn icon @click="addResult('retrospective')">
                                    <v-icon size="30" v-text="'mdi-plus-circle-outline'"/>
                                </v-btn>
                            </v-col>
                            <v-col cols="12" class="px-5">
                                <v-divider class="my-3"></v-divider>
                            </v-col>

                            <v-col cols="12" class="mt-3 px-5">
                                <v-card class="mb-4 pa-4" v-for="(item, i) in openRetrospective" :key="`${item.title}-${i}`">
                                    <div  class="d-flex justify-space-between align-center mb-2">
                                        <h4>{{ item.title }}</h4>

                                            <template>
                                                <div class="d-flex">
                                                            <v-btn icon color="grey" @click="edit(item)">
                                                                <v-icon size="24" v-text="'mdi-pencil'"/>
                                                            </v-btn>

                                                            <v-btn icon color="grey" class="ml-3" @click="deleteResult(item)">
                                                                <v-icon size="24" v-text="'mdi-delete-outline'"/>
                                                            </v-btn>
                                                </div>
                                            </template>
                                    </div>

                                    <p>{{ item.description }}</p>
                                </v-card>
                            </v-col>
                        </v-row>

                    </v-card>
                </v-col>



            </v-row>
        </v-container>

        <meeting-result-dialog :open="addDialog" :type="type" :formEdit="form" @add-task="addTask($event)"/>

    </div>

</template>

<script>
import MeetingResultDialog from "~/components/pages/meeting-result/MeetingResultDialog";
export default {
    name: "MeetingResult",
    components: {
        MeetingResultDialog
    },
    data() {
        return {
            pageTitle: this.$t('meetingResults'),
            addDialog: false,
            form: null,
            type: null,
            openReview: [
                /*{
                    title: 'My first Review Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },*/
            ],
            openRetrospective: [
            ],
        }
    },
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
        this.$store.dispatch('GET_MEETING_RESULTS').then(()=>{
            this.openReview = this.$store.state.meeting.filter((result) => {
                return result.meetingType === 'review'
            })
            this.openRetrospective= this.$store.state.meeting.filter((result) => {
                return result.meetingType === 'retrospective'
            })
        })
    },
    watch: {
        '$store.state.meeting'(val) {
            console.log('kkk',val)
            this.openReview = val.filter((result) => {
                return result.meetingType === 'review'
            })
            this.openRetrospective= val.filter((result) => {
                return result.meetingType === 'retrospective'
            })
            this.$nuxt.refresh()
        }
    },
    methods: {
        addTask(task) {
            this.addDialog = task
        },
        edit(item) {
            this.addDialog = true
            this.form = item
        },
        async deleteResult(item) {
            await this.$store.dispatch('POST_MEETING_RESULTS_DELETE',item)
        },
        addResult(type) {
            this.type = type
            this.addDialog = !this.addDialog
        }
    },

}
</script>

