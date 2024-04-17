<script>
    export default{
        props: ['isEdit'],
        data(){
            return{
                isEditing: false,
                isEnabled: false
            }
        },
        methods:{
            showEdit(){ 
                this.$emit('showEdit');

                this.isEditing = true;
                this.isEnabled = true;
            },
            hideEdit(){
                this.isEditing = false;
            }
        },
        watch:{
            isEdit(newValue){
                if(newValue){
                    if(this.isEnabled){
                        this.isEnabled = false;
                        this.isEditing = true;
                    }else{
                        this.isEditing = false;
                    }

                    this.$emit('hideEdit');
                }
            }
        }
    }
</script>

<template>
    <td @dblclick="showEdit()">
    <slot v-if="!isEditing">{{ field }}</slot>
    <span v-if="isEditing" class = "d-flex"><input class = "col-9" >
        <span @click = "hideEdit()" class = "d-flex justify-content-center col pointer">X</span>
        <span @click = "hideEdit()" class = "d-flex justify-content-center col pointer">✓</span>
    </span>

    </td>
</template>

<style scoped>
    .pointer:hover{
        cursor: pointer;
        color: gray;
    }
</style>