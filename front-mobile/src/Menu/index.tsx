import React from 'react';
import { StyleSheet, Text } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';
import Header from '../Header';
import { useNavigation } from '@react-navigation/native';

export default function Menu() {
    const navigation = useNavigation();

    const handleOnMembers = () => {
        navigation.navigate('MembersMenu');
    }
    
    const handleOnSchedule = () => {
        navigation.navigate('Schedule');
    }

    return (
        <>
        <Header />
        <RectButton style={styles.button} onPress={handleOnMembers}>
                <Text style={styles.buttonText}>INTEGRANTES</Text>
        </RectButton>
        <RectButton style={styles.button} onPress={handleOnSchedule}>
                <Text style={styles.buttonText}>AGENDA</Text>
        </RectButton>
        </>
        
    );
}

const styles = StyleSheet.create({
    button: {
        backgroundColor: '#FF0000',
        flexDirection: 'row',
        borderRadius: 10,
        marginTop: 100,
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
