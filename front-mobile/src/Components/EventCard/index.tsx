import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { Event } from '../../types/types';
import { formatLocalDate } from '../../utils/format';

type Props = {
    event: Event;
}

export default function EventCard({ event }: Props) {
    return (
        <>
            <View style={styles.container}>
                <Text style={styles.eventDescription}>{event.description}</Text>
                <Text style={styles.eventDate}>Data: {formatLocalDate(event.moment, "dd/MM/yyyy' 'HH:mm")}</Text>
                <Text style={styles.eventAddress}>Endereço: {event.address}</Text>
            </View>
        </>
    );
}

const styles = StyleSheet.create({
    container: {
        marginTop: '10%',
        marginLeft: '2%',
        marginRight: '2%',
        marginBottom: '2%',
        padding: 15,
        backgroundColor: '#FFF',
        shadowOpacity: 0.25,
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 4 },
        shadowRadius: 20,
        borderRadius: 10,
        elevation: 5
    },
    eventDescription: {
        fontWeight: 'bold',
        fontSize: 18,
        lineHeight: 25,
        letterSpacing: -0.24,
        color: '#263238',
        fontFamily: 'OpenSans_700Bold',
        textAlign: 'center'
    },
    eventDate: {
        fontSize: 15,
        lineHeight: 25,
        letterSpacing: -0.24,
        color: '#263238'
    },
    eventAddress: {
        fontSize: 15,
        lineHeight: 25,
        letterSpacing: -0.24,
        color: '#263238'
    }
});
