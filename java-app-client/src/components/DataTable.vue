<script>
    export default{
        props: ['data']
    }
</script>

<template>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="item in data" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.Username }}</td>
                <td>{{ item.Name }}</td>
                <td>{{ item.Phone }}</td>
                <td>{{ item.Email }}</td>
                <td>{{ item.Date }}</td>
                <td>{{ item.Action }}</td>
            </tr>
        </tbody>
    </table>
</template>