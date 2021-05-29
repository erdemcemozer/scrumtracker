<<template>
    <v-container class="fill-height d-flex align-center">
        <account-grid>

            <template #presentation>
                <account-presentation/>
            </template>

            <template #form>
                <account-registration/>
            </template>

        </account-grid>
    </v-container>
</template>

<script>
export default {
    name: "Registration",
    layout: 'account'
}
</script>
