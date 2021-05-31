<template>
    <v-container>
        <v-divider class="mb-5"/>
        <v-row>
            <v-col cols="12" md="6" class="mb-5">
                <sprint-details/>
            </v-col>

            <v-col cols="12" md="6" class="mb-5">
                <issue-details/>
            </v-col>

            <v-col cols="12" class="mb-5">
                <priority-and-type/>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import SprintDetails from "~/components/pages/dash-board/SprintDetails";
import IssueDetails from "~/components/pages/dash-board/IssueDetails";
import PriorityAndType from "~/components/pages/dash-board/PriorityAndType";
export default {
    name: "DashBoard",
    components: {
        SprintDetails,
        IssueDetails,
        PriorityAndType
    },
    data() {
        return {
            pageTitle: this.$t('dashBoard'),
        }
    },
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
    }
}
</script>

