<script>
    import DataTable from '@/components/DataTable.vue'

    export default{
        components:{
            DataTable
        },
        data(){
            return{
                userData: [
                    { id: "1", Username: "Ngetst", Name: "Yehrs", Phone: "998", Email: "yegor.d02152gmail.com", Date: "23.05.2024", checked: false},
                    { id: "2", Username: "Uniqeut", Name: "John", Phone: "123", Email: "john@example.com", Date: "24.05.2024", checked: false},
                    { id: "3", Username: "Taketsy", Name: "Jane", Phone: "456", Email: "jane@example.com", Date: "25.05.2024", checked: false},
                    { id: "4", Username: "Test", Name: "Jane", Phone: "3465235235", Email: "jane@example.com", Date: "25.05.2024", checked: false}
                ]
            }
        },
        methods:{
            dataDescSort(){
                this.userData.sort((a, b) => b.id - a.id);
            },
            dataAscSort(){
                this.userData.sort((a, b) => a.id - b.id);
            },
            deleteData(){
                this.userData = this.userData.filter(item => !item.checked);
            }
        }
    }
</script>

<template>
   <div class = "container-xxl mt-5"> 
            <h1 class="bold">User Table</h1>
            <div class = "row">
                <div class = "col-4 d-flex control-btns">
                        <div class = "dropdown">
                            <button class = "btn btn-secondary dropdown-toggle" type = "button" id = "actionDropdown" data-bs-toggle="dropdown" aria-expanded="false">Actions</button>
                            <ul class = "dropdown-menu" aria-labelledby="actionDropdown">
                                <li><a class="dropdown-item" href="#" @click = "deleteData()">Delete</a></li>
                                <li><a class="dropdown-item" href="#">Import Excel</a></li>
                                <li><a class="dropdown-item" href="#">Export Excel</a></li>
                            </ul>
                        </div>

                        <div class = "dropdown">
                            <button class = "btn btn-secondary dropdown-toggle" type = "button" id = "filterDropdown" data-bs-toggle="dropdown" aria-expanded="false">Filter</button>
                            <ul class = "dropdown-menu" aria-labelledby="filterDropdown">
                                <li><a class="dropdown-item" href="#" @click="dataAscSort()">By ID (Ascending Order)</a></li>
                                <li><a class="dropdown-item" href="#" @click="dataDescSort()">By ID (Descending Order)</a></li>
                            </ul>
                        </div>
                </div>
            </div>
            <div class = "container-xxl">
                <div class = "overflow-container">
                    <DataTable :data = "userData"> </DataTable>
                </div>
             </div>
      </div>
</template>

<style scoped>

</style>
