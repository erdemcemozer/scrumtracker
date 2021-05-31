<template>
    <v-row>
        <v-col cols="12" md="6">
            <v-card class="pa-3">
                <v-sparkline
                    :value="priority.value"
                    :gradient="priority.gradient"
                    :smooth="priority.radius || false"
                    :padding="priority.padding"
                    :line-width="priority.width"
                    :stroke-linecap="priority.lineCap"
                    :gradient-direction="priority.gradientDirection"
                    :fill="priority.fill"
                    :type="priority.type"
                    :auto-line-width="priority.autoLineWidth"
                    auto-draw/>
                <h4 class="text-center mt-3 text-h5" v-text="'Priority'"/>
            </v-card>
        </v-col>

        <v-col cols="12" md="6">
            <v-card class="pa-3">
                <v-sparkline
                    :value="type.value"
                    :gradient="type.gradient"
                    :smooth="type.radius || false"
                    :padding="type.padding"
                    :line-width="type.width"
                    :stroke-linecap="type.lineCap"
                    :gradient-direction="type.gradientDirection"
                    :fill="type.fill"
                    :type="type.type"
                    :auto-line-width="type.autoLineWidth"
                    auto-draw/>
                <h4 class="text-center mt-3 text-h5" v-text="'Type'"/>
            </v-card>
        </v-col>
    </v-row>

</template>

<script>
export default {
    name: "PriorityAndType",
    data() {
        return {
            priority: {
                width: 2,
                radius: 10,
                padding: 8,
                lineCap: 'round',
                value: [0, 2, 5, 9, 5, 10, 3, 5, 0, 0, 1, 8, 2, 9, 0],
                gradientDirection: 'top',
                fill: false,
                type: 'trend',
                autoLineWidth: false,
            },
            type: {
                width: 2,
                radius: 10,
                padding: 8,
                lineCap: 'round',
                value: [0, 2, 3, 7, 3, 9, 3, 3, 0, 0, 1, 8, 7, 9, 6],
                gradientDirection: 'top',
                fill: false,
                type: 'trend',
                autoLineWidth: false,
            },

        }
    }
}
</script>

