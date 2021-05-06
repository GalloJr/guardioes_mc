import React, { useState } from 'react';
import { Keyboard, KeyboardAvoidingView, Platform, StyleSheet, Text, TextInput, TouchableWithoutFeedback, View } from 'react-native';

import { Button } from '../Components/Button';
import HeaderOff from '../HeaderOff';
import { useNavigation } from '@react-navigation/core';

//https://medium.com/reactbrasil/consumindo-api-rest-com-autentica%C3%A7%C3%A3o-jwt-no-react-native-eec62b852ff3

export default function Login() {
    const [name, setName] = useState<string>();
    const [password, setPassword] = useState<string>();
    const navigation = useNavigation();

    const handleSubmit = () => {
        navigation.navigate('Menu');
    }

    function handleInputNameChange(value: string) {
        setName(value);
    }

    function handleInputPasswordChange(value: string) {
        setPassword(value);
    }

    return (
        <>
            <HeaderOff />
            <KeyboardAvoidingView
                style={styles.container}
                behavior={Platform.OS == 'ios' ? 'padding' : 'height'}
            >
                <TouchableWithoutFeedback onPress={Keyboard.dismiss}>
                    <View style={styles.content}>
                        <Text style={styles.title}>
                            Usuário
                        </Text>

                        <TextInput
                            style={styles.input}
                            placeholder="Digite o usuário"
                            onChangeText={handleInputNameChange}
                        >
                        </TextInput>

                        <Text style={styles.title}>
                            Senha
                        </Text>

                        <TextInput
                            style={styles.input}
                            placeholder="Digite a senha"
                            onChangeText={handleInputPasswordChange}
                        >
                        </TextInput>

                        <View style={styles.footer}>
                            <Button
                                title="Entrar"
                                onPress={handleSubmit}
                            />
                        </View>
                    </View>
                </TouchableWithoutFeedback>
            </KeyboardAvoidingView>
        </>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        width: '100%',
        alignItems: 'center',
        justifyContent: 'space-around'
    },
    content: {
        flex: 1,
        marginTop: '25%',
        width: '100%'
    },
    title: {
        color: '#263238',
        fontSize: 26,
        lineHeight: 35,
        fontWeight: 'bold',
        marginTop: 31,
        textAlign: 'center'
    },
    input: {
        borderBottomWidth: 1,
        borderColor: '#CFCFCF',
        color: '#52665A',
        width: '100%',
        fontSize: 18,
        marginTop: 50,
        padding: 10,
        textAlign: 'center'
    },
    footer: {
        width: '100%',
        marginTop: 40,
        paddingHorizontal: 20
    }
}
);