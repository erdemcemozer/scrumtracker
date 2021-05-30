<template>
    <div class="text-center">
        <v-dialog v-model="dialog" width="500" @click:outside="$emit('add-task', false)">

            <v-card class="pa-10">

                <h3 class="mb-6 text-center" v-text="$t('addAnnouncementTitle')"/>

                <v-row justify="center">
                    <v-col cols="12">
                        <v-text-field v-model="form.title"
                                      :label="$t('announcementTitle')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-bullhorn-outline"/>

                    </v-col>
                    <v-col cols="12">

                        <v-text-field v-model="form.description"
                                      :label="$t('description')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-comment-text-outline"/>

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
    name: "Dialog",
    props: {
        open: {
            default: false,
            type: Boolean
        },
        formEdit: {
            default: null,
            type: Object
        },
        type: {
            type: String
        }
    },
    data(){
        return {
            dialog: false,
            form: {
                title: null,
                description: null
            }
        }
    },
    methods:{
        async submit(){
            if(this.form?.meetingId){
                await this.$store.dispatch('POST_MEETING_RESULTS_UPDATE', {...this.form})
            }else{
                await this.$store.dispatch('POST_MEETING_RESULTS_ADD', {...this.form, type: this.type})
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
                this.form = {
                    ...val
                }
            },
            deep: true
        }
    },
}
</script>

