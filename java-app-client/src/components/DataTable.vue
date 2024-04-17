<script>
    import DataItem from "@/components/DataItem.vue";

    export default{
        components:{
            DataItem
        },
        props: ['data'],
        data(){
            return{
                isEdit: false
            }
        },
        methods:{
            enableEditState(){
                this.isEdit = true;
            },
            disableEditState(){
                this.isEdit = false;
            }
        }
    }
</script>

<template>
    <table>
        <thead>
            <tr>
                <th></th>
                <th>Code</th>
                <th>Product Title</th>
                <th>Link</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="item in data" :key="item.id">
                <td><input :id="item.id" type = "checkbox" v-model="item.checked"></td>
                <td> {{ item.id }} </td>
                <DataItem :isEdit="isEdit" @showEdit = "enableEditState()" @hideEdit = "disableEditState()"> {{ item.title }} </DataItem>
                <DataItem :isEdit="isEdit" @showEdit = "enableEditState()" @hideEdit = "disableEditState()"> <a :href = "item.link">{{ item.link }}</a> </DataItem>
                <DataItem :isEdit="isEdit" @showEdit = "enableEditState()" @hideEdit = "disableEditState()"> {{ item.description }} </DataItem>
                <DataItem :isEdit="isEdit" @showEdit = "enableEditState()" @hideEdit = "disableEditState()"> {{ item.price }} </DataItem>
            </tr>
        </tbody>
    </table>
</template>