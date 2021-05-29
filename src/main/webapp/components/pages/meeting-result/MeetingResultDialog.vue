<template>
    <v-dialog v-model="dialog" width="500">

        <v-card class="pa-10">

            <h3 class="mb-6 text-center" v-text="$t('addAnnouncementTitle')"/>

            <v-row justify="center">
                <v-col cols="12">
                    <v-text-field v-model="form.title"
                                  :label="$t('title')+':'"
                                  outlined dense rounded required
                                  prepend-inner-icon="mdi-format-title"/>

                </v-col>
                <v-col cols="12">

                    <v-text-field v-model="form.description"
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
</template>

<script>
export default {
    name: "MeetingResultDialog",
    props:{
        open: {
            type: Boolean,
        }
    },
    data(){
        return {
            dialog: false,
            form:{
                title: null,
                description: null
            }
        }
    },
    watch:{
        open(val){
            if(val === true || val === false){
                this.dialog = true
            }
        }
    },
    methods:{
        addTask(){
            this.$emit('add-task', this.form)
            /*this.form.title = null
            this.form.description = null*/
            this.dialog = false
        }
    }
}
</script>

