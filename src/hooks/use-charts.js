import { useState, useEffect } from 'react';
import typesService from '../services/types'

export default function useCharts() {
    const [data, setData] = useState([])

    useEffect(() => {
        async function getData() {
            const data = await typesService.getCharts()
            setData(data)
        }
        getData()
    }, [])

    return data
}