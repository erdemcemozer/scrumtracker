<template>
    <v-container>

        <v-card rounded="lg" color="transparent" class="neumerophism">

            <div class="d-flex pa-3">
                <v-text-field color="transparent"
                              class="neumerophism py-1 mt-0 fill-width mr-3"
                              v-model="search"
                              append-icon="mdi-magnify"
                              :label="$t('search')"
                              single-line flat rounded
                              hide-details/>
                <link-dialog/>
            </div>

            <v-divider/>

            <v-data-table light
                          :headers="headers"
                          :items="desserts"
                          :search="search"
                          class="transparent">

                <template #item.name="{item}">

                    <v-icon v-text="'mdi-arrow-right-thin-circle-outline'" class="mr-2" v-if="$vuetify.breakpoint.mdAndUp"/>

                    <a :href="item.name" target="_blank">
                        {{ item.name }}
                    </a>
                </template>

            </v-data-table>
        </v-card>

    </v-container>
</template>

<script>
import LinkDialog from "@/components/pages/usefulLinks/Dialog";

export default {
    name: "UsefulLinks",
    components: {
        LinkDialog
    },
    data() {
        return {
            pageTitle: this.$t('usefulLinks'),
            search: '',
            headers: [
                {
                    text: this.$t('link'),
                    align: 'start',
                    sortable: false,
                    value: 'name',
                },
                {
                    text: this.$t('description'),
                    sortable: false,
                    value: 'calories',
                },

            ],
            desserts: [
                {
                    name: 'https://www.youtube.com/',
                    calories: 'Detaylı bilgi almak için Youtube sayfasını ziyaret edebilirsiniz.',
                },
                {
                    name: 'https://github.com/SadettinAyyildiz',
                    calories: 'Github sayfamı ziyaret ederek detaylara ulaşabilirsiniz.',
                },
                {
                    name: 'https://www.w3schools.com/js/js_errors.asp',
                    calories: 'Javascrip hata yöntemleri için linke bakabilirsiniz',
                },
                {
                    name: 'https://www.google.com.tr/',
                    calories: 'Google sayfasını ziyaret etmeden olmaz.',
                },
                {
                    name: 'https://stackoverflow.com/questions/',
                    calories: 'İlgili hatanın linki bulundu',
                },
                {
                    name: 'https://www.biobilgi.com/',
                    calories: 'Güzel bir blog sitesi',
                },
                {
                    name: 'https://www.youtube.com/',
                    calories: 'Detaylı bilgi almak için Youtube sayfasını ziyaret edebilirsiniz.',
                },
                {
                    name: 'https://github.com/SadettinAyyildiz',
                    calories: 'Github sayfamı ziyaret ederek detaylara ulaşabilirsiniz.',
                },
                {
                    name: 'https://www.w3schools.com/js/js_errors.asp',
                    calories: 'Javascrip hata yöntemleri için linke bakabilirsiniz',
                },
                {
                    name: 'https://www.google.com.tr/',
                    calories: 'Google sayfasını ziyaret etmeden olmaz.',
                },
                {
                    name: 'https://stackoverflow.com/questions/',
                    calories: 'İlgili hatanın linki bulundu',
                },
                {
                    name: 'https://www.biobilgi.com/',
                    calories: 'Güzel bir blog sitesi',
                },
                {
                    name: 'https://www.youtube.com/',
                    calories: 'Detaylı bilgi almak için Youtube sayfasını ziyaret edebilirsiniz.',
                },
                {
                    name: 'https://github.com/SadettinAyyildiz',
                    calories: 'Github sayfamı ziyaret ederek detaylara ulaşabilirsiniz.',
                },
                {
                    name: 'https://www.w3schools.com/js/js_errors.asp',
                    calories: 'Javascrip hata yöntemleri için linke bakabilirsiniz',
                },
                {
                    name: 'https://www.google.com.tr/',
                    calories: 'Google sayfasını ziyaret etmeden olmaz.',
                },
                {
                    name: 'https://stackoverflow.com/questions/',
                    calories: 'İlgili hatanın linki bulundu',
                },
                {
                    name: 'https://www.biobilgi.com/',
                    calories: 'Güzel bir blog sitesi',
                },
            ],
        }
    },
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
    }
}
</script>

