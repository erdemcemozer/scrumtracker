<template>
    <v-dialog v-model="dialog" width="500">

        <v-card class="pa-10">

            {{sprint}}

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
    name: "AddTaskDialog",
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
            },
            sprint: this.$storage.getCookie('sprintName')
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
            this.$store.dispatch('POST_SPRINT_ADD', this.form)
            this.dialog = false
        }
    }
}
</script>

