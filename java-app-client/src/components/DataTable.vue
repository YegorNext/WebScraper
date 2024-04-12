<script>
    import DataItem from "@/components/DataItem.vue";

    export default{
        components:{
            DataItem
        },
        props: ['data'],
        data(){
            return{
                isEdit: false,
            }
        },
        methods:{
            test(){
                this.isEdit = true;
            }
        }
    }
</script>

<template>
    <table>
        <thead>
            <tr>
                <th></th>
                <th>ID</th>
                <th>Username</th>
                <th @click = "test()">Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="item in data" :key="item.id">
                <td><input :id="item.id" type = "checkbox" v-model="item.checked"></td>
                <DataItem :isEdit = "isEdit"> {{ item.id }} </DataItem>
                <DataItem :isEdit = "isEdit">{{ item.Username }}</DataItem>
                <DataItem :isEdit = "isEdit">{{ item.Name }}</DataItem>
                <DataItem :isEdit = "isEdit">{{ item.Phone }}</DataItem>
                <DataItem :isEdit = "isEdit">{{ item.Email }}</DataItem>
                <DataItem :isEdit = "isEdit">{{ item.Date }}</DataItem>
            </tr>
        </tbody>
    </table>
</template>