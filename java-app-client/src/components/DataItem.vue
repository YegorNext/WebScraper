<script>
    export default{
        props: ['isEdit'],
        data(){
            return{
                isEditing: false,
            }
        },
        methods:{
            showEdit(){
                this.isEditing = true;
            },
            hideEdit(){
                this.isEditing = false;
            }
        },
        watch: {
            isEdit(newValue, oldValue){
                if(newValue && this.isEditing){
                    this.isEditing = false;
                }
            }
        }
    }
</script>

<template>
    <td @dblclick="showEdit()">
    <slot v-if="!isEditing">{{ field }}</slot>
    <input v-if="isEditing">

    </td>
</template>