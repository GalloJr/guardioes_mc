import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';

export default function Home() {

    const handleOnPress = () => {

    }
    return (
        <View style={styles.container}>
            <Image source={require('../assets/logo.png')} onPress={ handleOnPress }/>
        </View>
    );
}

const styles = StyleSheet.create(
    {
        container: {
            marginTop: '23%',
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
            fontSize: 16,
            marginTop: 15,
            lineHeight: 22,
            textAlign: 'center'
        },
        footer: {
            marginTop: '5%',
            alignItems: 'center'
        },
        button: {
            backgroundColor: '#DA5C5C',
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
