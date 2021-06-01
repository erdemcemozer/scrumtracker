<template>
    <div class="text-center">
        <v-dialog v-model="dialog" width="500" @click:outside="outsideClicked">
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
                        <v-text-field v-model="form.announcementTitle"
                                      :label="$t('announcementTitle')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-bullhorn-outline"/>

                    </v-col>
                    <v-col cols="12">

                        <v-text-field v-model="form.announcementDescription"
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
            default: {
                announcementTitle: null,
                announcementDescription: null
            },
            type: Object
        }
    },
    data(){
        return {
            dialog: false,
            form: {
                announcementTitle: null,
                announcementDescription: null
            }
        }
    },
    methods:{
        async submit(){
            if(this.form?.announcementId){
                await this.$store.dispatch('POST_ANNOUNCEMENTS_UPDATE', this.form).then(()=>{
                    this.$nuxt.refresh()
                })
            }else {
                await this.$store.dispatch('POST_ANNOUNCEMENTS_ADD', this.form).then(()=>{
                    this.$nuxt.refresh()
                })
            }

            this.$emit('add-task', false)
            this.dialog = false
            this.form = {
                announcementTitle: null,
                announcementDescription: null
            }

        },
        outsideClicked() {
            this.$emit('add-task', false)
            /*this.form = {
                announcementTitle: null,
                announcementDescription: null
            }*/
        }
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

