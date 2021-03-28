<template>
    <v-form @submit="submit">

        <h1 class="font-weight-bold text-center text-h6 text-md-h5 mb-4 mb-md-8"
            v-text="$t('loginTitle')"/>

        <v-row justify="center">
            <v-col cols="12" sm="6">
                <v-text-field v-model="form.email"
                              label="E-mail:"
                              outlined dense rounded
                              type="email" required
                              prepend-inner-icon="mdi-account-outline"/>

            </v-col>
            <v-col cols="12" sm="6">

                <v-text-field v-model="form.password"
                              label="Şifre:"
                              outlined dense rounded
                              type="password" required
                              prepend-inner-icon="mdi-key-outline"/>

            </v-col>
            <v-col cols="12" sm="6">
                <v-text-field v-model="form.email"
                              label="E-mail:"
                              outlined dense rounded
                              type="email" required
                              prepend-inner-icon="mdi-account-outline"/>

            </v-col>
            <v-col cols="12" sm="6">

                <v-text-field v-model="form.password"
                              label="Şifre:"
                              outlined dense rounded
                              type="password" required
                              prepend-inner-icon="mdi-key-outline"/>

            </v-col>
            <v-col cols="12" sm="6">
                <v-text-field v-model="form.email"
                              label="E-mail:"
                              outlined dense rounded
                              type="email" required
                              prepend-inner-icon="mdi-account-outline"/>

            </v-col>
            <v-col cols="12" sm="6">

                <v-text-field v-model="form.password"
                              label="Şifre:"
                              outlined dense rounded
                              type="password" required
                              prepend-inner-icon="mdi-key-outline"/>

            </v-col>

<!--            <v-col cols="12" sm="7" md="8">

                <v-text-field v-model="form.email"
                              label="E-mail:"
                              outlined dense rounded
                              type="email" required
                              prepend-inner-icon="mdi-account-outline"/>

                <v-text-field v-model="form.password"
                              label="Şifre:"
                              outlined dense rounded
                              type="password" required
                              prepend-inner-icon="mdi-key-outline"/>

                <v-checkbox v-model="form.rememberMe" label="Beni hatırla." class="mt-0 pt-0"/>

                <v-btn rounded depressed block color="primary" type="submit" @click.prevent="submit">
                    Giriş Yap
                </v-btn>

                <div class="text-center mt-4 mt-md-7">
                    <p class="mb-1" v-text="'Bir ScrumTracker hesabın yok mu ?'"/>

                    <v-btn text rounded color="primary">
                        Kayıt ol
                    </v-btn>
                </div>

            </v-col>-->

        </v-row>

        <v-checkbox v-model="form.rememberMe" label="Beni hatırla." class="mt-0 pt-0"/>

        <v-btn rounded depressed block color="primary" type="submit" @click.prevent="submit">
            Giriş Yap
        </v-btn>

        <div class="text-center mt-4 mt-md-7">
            <p class="mb-1" v-text="'Bir ScrumTracker hesabın yok mu ?'"/>

            <v-btn text rounded color="primary">
                Kayıt ol
            </v-btn>
        </div>
    </v-form>
</template>

<script>
export default {
    name: "Login",
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
            alert("aaa")
        }
    }
}
</script>
