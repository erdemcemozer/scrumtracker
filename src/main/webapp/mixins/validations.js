import {email, maxLength, minLength, numeric, required, alphaNum, helpers, sameAs} from "vuelidate/lib/validators";
const checkPhoneNumber = helpers.regex('checkPhoneNumber', /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/);
const checkAlphabetic = helpers.regex('checkAlphabetic', /^[a-zA-ZÀ-ž\s*]*$/);
const checkTcNumber = tcNo => {
    tcNo = tcNo.toString();
    let isEleven = /^[0-9]{11}$/.test(tcNo);
    let totalX = 0;
    for (let i = 0; i < 10; i++) {
        totalX += Number(tcNo.substr(i, 1));
    }
    let isRuleX = totalX % 10 == tcNo.substr(10,1);
    let totalY1 = 0;
    let totalY2 = 0;
    for (let i = 0; i < 10; i+=2) {
        totalY1 += Number(tcNo.substr(i, 1));
    }
    for (let i = 1; i < 10; i+=2) {
        totalY2 += Number(tcNo.substr(i, 1));
    }
    let isRuleY = ((totalY1 * 7) - totalY2) % 10 == tcNo.substr(9,0);
    return isEleven && isRuleX && isRuleY;
}

export const loginValidations = {
    validations: {
        form: {
            email: {
                required,
                email
            },
            password: {
                required,
            }
        }
    },
    computed: {
        emailErrors() {
            const errors = [];
            if (!this.$v.form.email.$dirty) return errors;
            !this.$v.form.email.required && errors.push(this.$t('isRequired'));
            !this.$v.form.email.email && errors.push(this.$t('invalidEmailError'));
            return errors
        },
        passwordErrors() {
            const errors = [];
            if (!this.$v.form.password.$dirty) return errors;
            !this.$v.form.password.required && errors.push(this.$t('isRequired'));
            return errors
        }
    },
}

export const registrationValidations = {
    validations: {
        form: {
            name: {
                required,
                checkAlphabetic
            },
            surname: {
                required,
                checkAlphabetic
            },
            email: {
                email,
                required,
            },
            phone: {
                required,
                minLength: minLength(5),
                numeric,
                checkPhoneNumber
            },
            password: {
                required,
            },
            passwordAgain: {
                required,
                passwordAgain: sameAs('password')
            }
        },
    },
    computed: {
        nameErrors() {
            const errors = [];
            if (!this.$v.form.name.$dirty) return errors;
            !this.$v.form.name.required && errors.push(this.$t('isRequired'));
            !this.$v.form.name.checkAlphabetic && errors.push(this.$t('invalidNameError'));
            return errors
        },
        surnameErrors() {
            const errors = [];
            if (!this.$v.form.surname.$dirty) return errors;
            !this.$v.form.surname.required && errors.push(this.$t('isRequired'));
            !this.$v.form.surname.checkAlphabetic && errors.push(this.$t('invalidSurnameError'));
            return errors
        },
        emailErrors() {
            const errors = [];
            if (!this.$v.form.email.$dirty) return errors;
            !this.$v.form.email.required && errors.push(this.$t('isRequired'));
            !this.$v.form.email.email && errors.push(this.$t('invalidEmailError'));
            return errors
        },
        phoneNumberErrors() {
            const errors = [];
            if (!this.$v.form.phone.$dirty) return errors;
            !this.$v.form.phone.required && errors.push(this.$t('isRequired'));
            !this.$v.form.phone.minLength && errors.push(this.$t('invalidPhoneNumberError'));
            !this.$v.form.phone.checkPhoneNumber && errors.push(this.$t('invalidPhoneNumberError'));
            return errors
        },
        passwordErrors() {
            const errors = [];
            if (!this.$v.form.password.$dirty) return errors;
            !this.$v.form.password.required && errors.push(this.$t('isRequired'));
            return errors
        },
        passwordAgainErrors() {
            const errors = [];
            if (!this.$v.form.passwordAgain.$dirty) return errors;
            !this.$v.form.passwordAgain.required && errors.push(this.$t('isRequired'));
            !this.$v.form.passwordAgain.sameAs && errors.push(this.$t('sameAsPassword'));
            return errors
        }
    },
}
