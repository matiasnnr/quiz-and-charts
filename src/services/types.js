import axios from 'axios'

const baseUrl = 'http://localhost:8080/'

const getAll = async () => {
  const response = await axios.get(`${baseUrl}/read`)
  return response.data
}

const getTypes = async () => {
  const response = await axios.get(`${baseUrl}/readtypes`)
  return response.data
}

const getCharts = async () => {
  const response = await axios.get(`${baseUrl}/charts`)
  return response.data
}

const create = async (type) => {
  const response = await axios.post(`${baseUrl}/create`, type)
  return response.data
}

const update = async (type) => {
  const response = await axios.put(`${baseUrl}/update`, type)
  return response.data
}

const remove = async (type) => {
  const response = await axios.delete(`${baseUrl}/delete`, type)
  return response.data
}

// eslint-disable-next-line import/no-anonymous-default-export
export default { getAll, getTypes, getCharts, create, update, remove }