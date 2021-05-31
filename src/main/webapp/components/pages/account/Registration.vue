<template>
    <v-form @submit="submit">

        <h1 class="font-weight-bold text-center text-h6 text-md-h5 mb-4 mb-md-8"
            :class="$vuetify.breakpoint.smAndDown ? 'mt-4 px-10' : ''"
            v-text="$t('registrationTitle')"/>

        <v-row justify="center">

            <v-col cols="12" sm="6" class="mb-2">
                <v-text-field v-model="form.name"
                              :label="$t('name')"
                              outlined dense rounded required
                              prepend-inner-icon="mdi-account-outline"
                              :error-messages="nameErrors"
                              @input="$v.form.name.$touch()"/>

            </v-col>

            <v-col cols="12" sm="6" class="mb-2">
                <v-text-field v-model="form.surname"
                              :label="$t('surname')"
                              outlined dense rounded required
                              prepend-inner-icon="mdi-account-outline"
                              :error-messages="surnameErrors"
                              @input="$v.form.surname.$touch()"/>
            </v-col>

            <v-col cols="12" sm="6" class="mb-2">
                <v-text-field v-model="form.email"
                              :label="$t('email')"
                              outlined dense rounded
                              type="email" required
                              prepend-inner-icon="mdi-email-outline"
                              :error-messages="emailErrors"
                              @input="$v.form.email.$touch()"/>
            </v-col>

            <v-col cols="12" sm="6" class="mb-2">
                <v-text-field v-model="form.phone"
                              :label="$t('phone')"
                              outlined dense rounded
                              type="tel" required
                              prepend-inner-icon="mdi-phone-outline"
                              :error-messages="phoneNumberErrors"
                              @input="$v.form.phone.$touch()"/>
            </v-col>

            <v-col cols="12" sm="6" class="mb-2">
                <v-text-field v-model="form.password"
                              :label="$t('password')"
                              outlined dense rounded
                              type="password" required
                              prepend-inner-icon="mdi-key-outline"
                              :error-messages="passwordErrors"
                              @input="$v.form.password.$touch()"/>
            </v-col>

            <v-col cols="12" sm="6" class="mb-2">
                <v-text-field v-model="form.passwordAgain"
                              :label="$t('verifyPassword')"
                              outlined dense rounded
                              type="password" required
                              prepend-inner-icon="mdi-key-outline"
                              :error-messages="passwordAgainErrors"
                              @input="$v.form.passwordAgain.$touch()"/>
            </v-col>

        </v-row>

        <v-checkbox v-model="form.rememberMe" :label="$t('rememberMe')" class="mt-0 pt-0"/>

        <v-btn rounded depressed block color="primary" type="submit" @click.prevent.stop="submit">
            {{ $t('signUp') }}
        </v-btn>

        <div class="text-center mt-4 mt-md-7">
            <p class="mb-1" v-text="$t('doYouHaveAccount')"/>

            <v-btn text rounded color="primary" to="login">
                {{ $t('login') }}
            </v-btn>
        </div>
    </v-form>
</template>

<script>
import {validationMixin} from 'vuelidate'
import { registrationValidations } from '@/mixins/validations.js'
export default {
    name: "Registration",
    mixins: [registrationValidations, validationMixin],
    data() {
        return {
            form: {
                name: null,
                surname: null,
                email: null,
                phone: null,
                password: null,
                passwordAgain: null,
                rememberMe: false,
            }
        }
    },
    methods: {
        async submit() {
            this.$v.form.$touch();

            if(!this.$v.form.$anyError) {
                await this.$store.dispatch('POST_LOGIN_REGISTER', this.form).then((response) => {
                    if(response) {
                        this.$router.push('/account/login')
                    }
                })
            }
        }
    }
}
</script>
