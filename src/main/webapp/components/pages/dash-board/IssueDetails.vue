<template>
    <v-card class="pa-3" height="300">
        <h4 class="text-center mt-3 text-h5" v-text="'Issues Details'"/>
        <v-divider class="my-3"/>
        <div class="d-flex">
            <div class="mr-5">
               <p class="text-subtitle-2">Number of Issues:</p>
               <p class="text-subtitle-2">Number of In Progress Issues:</p>
               <p class="text-subtitle-2">Number of Open Issues:</p>
               <p class="text-subtitle-2">Number of Test Issues:</p>
               <p class="text-subtitle-2">Number of Done Issues:</p>
            </div>
            <div>
                <p>3</p>
                <p>5</p>
                <p>6</p>
                <p>8</p>
                <p>1</p>
            </div>
        </div>
    </v-card>
</template>

<script>
export default {
    name: "IssueDetails"
}
</script>

