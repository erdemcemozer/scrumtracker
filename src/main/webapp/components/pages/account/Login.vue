<template>
    <v-form @submit="submit">

        <h1 class="font-weight-bold text-center text-h6 text-md-h5 mb-4 mb-md-8"
            :class="$vuetify.breakpoint.smAndDown ? 'mt-4 px-10' : ''"
            v-text="$t('loginTitle')"/>

        <v-row justify="center">

            <v-col cols="12" sm="7" md="8">

                <v-text-field v-model="form.email"
                              class="mb-2"
                              :label="$t('email')"
                              outlined dense rounded
                              type="email" required
                              prepend-inner-icon="mdi-account-outline"
                              :error-messages="emailErrors"
                              @input="$v.form.email.$touch()"/>

                <v-text-field v-model="form.password"
                              class="mb-2"
                              :label="$t('password')"
                              outlined dense rounded
                              type="password" required
                              prepend-inner-icon="mdi-key-outline"
                              :error-messages="passwordErrors"
                              @input="$v.form.password.$touch()"/>

                <v-checkbox v-model="form.rememberMe" :label="$t('rememberMe')" class="mt-0 pt-0"/>

                <v-btn rounded depressed block color="primary" type="submit" @click.prevent="submit">
                    {{ $t('login') }}
                </v-btn>

                <div class="text-center mt-4 mt-md-7">
                    <p class="mb-1" v-text="$t('dontYouHaveAccount')"/>

                    <v-btn text rounded color="primary" to="registration">
                        {{ $t('signUp') }}
                    </v-btn>
                </div>

            </v-col>

        </v-row>

    </v-form>
</template>

<script>
import {validationMixin} from 'vuelidate'
import { loginValidations } from '@/mixins/validations.js'
export default {
    name: "Login",
    mixins: [loginValidations, validationMixin],
    data() {
        return {
            form: {
                email: null,
                password: null,
                rememberMe: false,
            }
        }
    },
    methods: {
        async submit() {
            this.$v.form.$touch();
            if(!this.$v.form.$anyError) {
                await this.$store.dispatch('POST_LOGIN', this.form).then((response) => {
                    if(response) {
                        this.$router.push('/sections/dash-board')
                    }
                })
            }
        }
    }
}
</script>
