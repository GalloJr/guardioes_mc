import React from 'react';
import { StyleSheet, Text } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';
import Header from '../Header';
import { useNavigation } from '@react-navigation/native';

export default function MembersMenu() {
    const navigation = useNavigation();

    const handleOnMembers = () => {
        navigation.navigate('Members');
    }

    const handleOnNomad = () => {
        navigation.navigate('Nomads');
    }

    const handleOnMemoriam = () => {
        navigation.navigate('Memorian');
    }

    const handleOnDirectors = () => {
        navigation.navigate('Directors');
    }

    return (
        <>
            <Header />
            <RectButton style={styles.button} onPress={handleOnDirectors}>
                <Text style={styles.buttonText}>Diretoria</Text>
            </RectButton>
            <RectButton style={styles.button} onPress={handleOnNomad}>
                <Text style={styles.buttonText}>Nomades</Text>
            </RectButton>
            <RectButton style={styles.button} onPress={handleOnMembers}>
                <Text style={styles.buttonText}>Integrantes</Text>
            </RectButton>
            <RectButton style={styles.button} onPress={handleOnMemoriam}>
                <Text style={styles.buttonText}>In Memorian</Text>
            </RectButton>
        </>

    );
}

const styles = StyleSheet.create({
    button: {
        backgroundColor: '#FF0000',
        flexDirection: 'row',
        borderRadius: 10,
        marginTop: 80,
        marginLeft: '10%',
        marginRight: '10%',
        alignItems: 'center',
        justifyContent: 'center'
    },
    buttonText: {
        paddingTop: 15,
        paddingBottom: 15,
        paddingLeft: 50,
        paddingRight: 50,
        fontWeight: 'bold',
        fontSize: 18,
        color: '#FFF',
        letterSpacing: -0.24,
        fontFamily: 'OpenSans_700Bold'
    }
});
