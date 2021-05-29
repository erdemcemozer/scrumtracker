<template>
    <div>
        <v-container>
            <v-row>

                <v-col cols="12" md="6">
                    <v-card tile flat color="transparent">
                        <v-row>
                            <v-col cols="12" class="d-flex justify-space-between align-center pt-2 px-10">
                                <h4 class="text-h6">Review</h4>
                                <v-btn icon @click="addDialog = !addDialog">
                                    <v-icon size="30" v-text="'mdi-plus-circle-outline'"/>
                                </v-btn>
                            </v-col>
                            <v-col cols="12" class="px-5">
                                <v-divider class="my-3"></v-divider>
                            </v-col>

                            <v-col cols="12" class="mt-3 px-5">
                                <v-card class="mb-4 pa-4" v-for="(review, i) in openReview" :key="`${review.title}-${i}`">
                                    <h4>{{ review.title }}</h4>
                                    <p>{{ review.description }}</p>
                                </v-card>
                            </v-col>
                        </v-row>



                    </v-card>
                </v-col>

                <v-col cols="12" md="6">
                    <v-card tile flat color="transparent">
                        <v-row>
                            <v-col cols="12" class="d-flex justify-space-between align-center pt-2 px-10">
                                <h4 class="text-h6">Retrospective</h4>
                                <v-btn icon @click="addDialog = !addDialog">
                                    <v-icon size="30" v-text="'mdi-plus-circle-outline'"/>
                                </v-btn>
                            </v-col>
                            <v-col cols="12" class="px-5">
                                <v-divider class="my-3"></v-divider>
                            </v-col>

                            <v-col cols="12" class="mt-3 px-5">
                                <v-card class="mb-4 pa-4" v-for="(retrospective, i) in openRetrospective" :key="`${retrospective.title}-${i}`">
                                    <h4>{{ retrospective.title }}</h4>
                                    <p>{{ retrospective.description }}</p>
                                </v-card>
                            </v-col>
                        </v-row>

                    </v-card>
                </v-col>

            </v-row>
        </v-container>

        <meeting-result-dialog :open="addDialog" @add-result="addResult($event)"/>

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
            openReview: [
                {
                    id: 1,
                    title: 'My first Review Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },
                {
                    id: 2,
                    title: 'My Second Review Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },
                {
                    id: 3,
                    title: 'My Third Review Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },
            ],
            openRetrospective: [
                {
                    id: 1,
                    title: 'My first Retrospective Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },
                {
                    id: 2,
                    title: 'My Second Retrospective Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },
                {
                    id: 3,
                    title: 'My Third Retrospective Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },
            ],
        }
    },
    methods: {
        addResult(result) {
            this.openRetrospective.push(result)
        },
    },
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
    }
}
</script>

