import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';
import Header from '../Header';

export default function Visitors() {

    const navigation = useNavigation();

    const handleOnPress = () => {
        navigation.navigate('Members');
    }

    return (
        <>
            <Header />
            <View style={styles.container}>
                <Text style={styles.title}>
                    História do M.C.
                </Text>
                <Text style={styles.subTitle}>
                    Moto Clube fundado em 1998, pelos amigos André e Lincon, o significado do brasão é que o cão cibernético é um guardião que olha e cuida de nossas motos.
                    O Guardiões M. C. conta com uma filial em Santa Catarina e uma filial na Bahia alem da sede em São José dos Campos que conta atualmente com 38 membros sendo 8 deles da diretoria e 3 Old Dogs que já são integrantes a mais de 15 anos.
                </Text>
                <Text style={styles.title}>Fotos</Text>
                <Image source={require('../assets/membros.png')} />
                <Text style={styles.title}>Sede</Text>
                <Text style={styles.subTitle}>
                    R. Manoel Bôsco Ribeiro, 46 - Jardim das Industrias, São José dos Campos - SP, 12241-070
                </Text>
            </View>
            <View style={styles.footer}>
                <RectButton style={styles.button} onPress={handleOnPress}>
                    <Text style={styles.buttonText}>MEMBROS</Text>
                </RectButton>
            </View>
        </>
    );
}

const styles = StyleSheet.create(
    {
        container: {
            marginTop: '5%',
            alignItems: 'center'
        },
        title: {
            color: '#263238',
            fontSize: 26,
            lineHeight: 35,
            fontWeight: 'bold',
            marginTop: 31,
            textAlign: 'center'
        },
        subTitle: {
            color: '#9E9E9E',
            fontSize: 23,
            marginTop: 15,
            lineHeight: 22,
            textAlign: 'center'
        },
        footer: {
            marginTop: '5%',
            alignItems: 'center'
        },
        button: {
            backgroundColor: '#FF0000',
            flexDirection: 'row',
            borderRadius: 10
        },
        buttonText: {
            paddingTop: 15,
            paddingBottom: 15,
            paddingLeft: 50,
            paddingRight: 50,
            fontWeight: 'bold',
            fontSize: 18,
            color: '#FFF',
            letterSpacing: -0.24
        }
    }
);
