<template>

        <v-card flat tile color="transparent">

            <v-divider class="my-2"/>

            <v-container>
            <v-card-text class="d-flex justify-space-start align-center my-10">

                <v-list-item-avatar size="72">
                    <!--<v-img src="https://avatars.githubusercontent.com/u/53340224?s=460&u=baa02bb677c9c08b8806f65f942a2e56eb30dd9a&v=4"/> -->
                    <v-img src="https://www.technobezz.com/files/uploads/2021/02/X462YQ4HIJEGHHX2I3LXRV4G7A.jpg"/>
                </v-list-item-avatar>

                    <nuxt-link to="/" class="ml-3 text-capitalize" v-text="$t('changePhoto')"/>

            </v-card-text>

                <v-form>
                    <v-row justify="center">

                        <v-col cols="12" sm="6">
                            <v-text-field v-model="form.name"
                                          :label="$t('name')"
                                          outlined dense rounded required
                                          prepend-inner-icon="mdi-account-outline"
                                          :error-messages="nameErrors"
                                          @input="$v.form.name.$touch()"/>
                        </v-col>

                        <v-col cols="12" sm="6">
                            <v-text-field v-model="form.surname"
                                          :label="$t('surname')"
                                          outlined dense rounded required
                                          prepend-inner-icon="mdi-account-outline"
                                          :error-messages="surnameErrors"
                                          @input="$v.form.surname.$touch()"/>
                        </v-col>

                        <v-col cols="12" sm="6">
                            <v-text-field v-model="form.email"
                                          :label=" $t('email') "
                                          outlined dense rounded disabled
                                          type="email" required
                                          prepend-inner-icon="mdi-email-outline"
                                          :error-messages="emailErrors"
                                          @input="$v.form.email.$touch()"/>
                        </v-col>

                        <v-col cols="12" sm="6">
                            <v-text-field v-model="form.phone"
                                          :label="$t('phone')"
                                          outlined dense rounded
                                          type="tel" required
                                          prepend-inner-icon="mdi-phone-outline"
                                          :error-messages="phoneNumberErrors"
                                          @input="$v.form.phone.$touch()"/>
                        </v-col>

                        <v-col cols="12" sm="6">
                            <v-text-field v-model="form.password"
                                          :label="$t('password')"
                                          outlined dense rounded
                                          type="password" required
                                          prepend-inner-icon="mdi-key-outline"
                                          :error-messages="passwordErrors"
                                          @input="$v.form.password.$touch()"/>
                        </v-col>

                        <!--<v-col cols="12" sm="6">
                            <v-text-field v-model="passwordAgain"
                                          :label="$t('verifyPassword')"
                                          outlined dense rounded
                                          type="password" required
                                          prepend-inner-icon="mdi-key-outline"
                                          :error-messages="passwordAgainErrors"
                                          @input="$v.passwordAgain.$touch()"/>
                        </v-col> -->

                    </v-row>

                </v-form>

                <div class="d-flex justify-center mt-4">
                    <v-btn rounded depressed color="primary" type="submit" @click="submit" class="px-16">
                        {{ $t('save') }}
                    </v-btn>
                </div>

            </v-container>
        </v-card>


</template>

<script>
import {validationMixin} from 'vuelidate'
import { registrationValidations } from '@/mixins/validations.js'
export default {
    name: "Settings",
    mixins: [registrationValidations, validationMixin],
    data() {
        return {
            pageTitle: this.$t('settings'),
            form: {
                name: null,
                surname: null,
                email: this.$storage.getCookie('email')?this.$storage.getCookie('email'):null,
                phone: null,
                password: null,
            },
        }
    },
    watch: {
        '$store.state.profileInfo'(val) {
            this.form = {...val}
            this.$nuxt.refresh()
        }
    },
    methods: {
            async submit() {
                this.$v.form.$touch();
                if(!this.$v.form.name.$anyError && !this.$v.form.surname.$anyError && !this.$v.form.email.$anyError &&
                    !this.$v.form.phone.$anyError && !this.$v.form.password.$anyError){
                    this.$storage.setCookie('email', this.form.email)
                    await this.$store.dispatch('POST_PROFILE_UPDATE',this.form)
                }
            }
    },
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
        this.$store.dispatch('POST_PROFILE_LOGIN').then(()=>{
                this.form = {
                    ...this.$store.state.profileInfo
                }
        })
    }
}
</script>

