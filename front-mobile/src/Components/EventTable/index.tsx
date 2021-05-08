import { useIsFocused } from "@react-navigation/core";
import React, { useEffect, useState } from "react";
import { Alert, ScrollView, Text, TouchableWithoutFeedback, StyleSheet } from "react-native";
import { fetchEvents } from "../../api";
import { Event } from "../../types/types";
import EventCard from "../EventCard";

function EventTable() {

    const [events, setEvents] = useState<Event[]>([]);
    const [isLoading, setIsLoading] = useState(false);
    const isFocused = useIsFocused();


    const fetchData = () => {
        setIsLoading(true);
        //Utilizar fetchEventsByDate(event.moment)
        fetchEvents()
            .then(response => setEvents(response.data))
            .catch(error => Alert.alert('Houve um erro ao buscar os eventos!'))
            .finally(() => setIsLoading(false));
    }

    useEffect(() => {
        if (isFocused) {
            fetchData();
        }
    }, [isFocused]);

    return (
        <>
            <ScrollView style={styles.container}>
                {isLoading ? (
                    <Text> Buscando eventos...</Text>
                ) : (
                    events.map(event => (
                        <TouchableWithoutFeedback key={event.id}>
                            <EventCard event={event} />
                        </TouchableWithoutFeedback>
                    ))
                )}
            </ScrollView>
        </>

    );
}

export default EventTable;

const styles = StyleSheet.create({
    container: {
        paddingRight: '5%',
        paddingLeft: '5%'
    }
});