<script>
    import DataTable from '@/components/DataTable.vue'
    import axios from 'axios';

    export default{
        components:{
            DataTable
        },
        data(){
            return{
                userData: [],
                update: false,
                success: false,
                url:'',

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
                const checkedData = this.userData.filter(item => item.checked);
                
                for(let element of checkedData){
                    try{
                        axios.delete(`http://ec2-13-48-138-18.eu-north-1.compute.amazonaws.com:8080/products/${element.id}`);
                    } catch(error){
                        console.error("Sending error: ", error);
                    }
                }

                this.userData = this.userData.filter(item => !item.checked);
            },
            async submitForm() {
                this.update = true;

                try {
                    await axios.post('http://ec2-13-48-138-18.eu-north-1.compute.amazonaws.com:8080/list/', { url: this.url });
                    
                    this.getData();
                    this.update = false;

                } catch (error) {

                    this.update = false;
                    this.success = true;
                    console.error('Error:', error);
                }
            },
            getExcel(){
                window.location.href = 'http://ec2-13-48-138-18.eu-north-1.compute.amazonaws.com:8080/list/';
            },
            async getData(){
                try {
                    const response = await axios.get('http://ec2-13-48-138-18.eu-north-1.compute.amazonaws.com:8080/products/');
                    this.userData = response.data;
                } catch (error) {
                    console.error('Error fetching data:', error);
                }
            }
        },
        async created(){
            this.getData();
        }
    }
</script>

<template>
   <div class = "container-xxl mt-5"> 
            <h1 class="bold">Products Table</h1>
            <div>Dubina Yehor, Group 122 - 20 - 4</div>
            <div class="spinner-border" role="status" v-if="update">
                <span class="visually-hidden">Loading...</span>
            </div>

            <div v-if = "success">
                <span style = "color: red;">IMPORT WAS UNSUCCESSFULL! TRY ANOTHER LINK</span>
            </div>

            <div class = "row">
                <div class = "col-4 d-flex control-btns">
                        <div class = "dropdown">
                            <button class = "btn btn-secondary dropdown-toggle" type = "button" id = "actionDropdown" data-bs-toggle="dropdown" aria-expanded="false">Actions</button>
                            <ul class = "dropdown-menu" aria-labelledby="actionDropdown">
                                <li><a class="dropdown-item" href="#" @click = "deleteData()">Delete</a></li>
                                <li><a class="dropdown-item" href="#" @click = "getExcel()">Export Excel</a></li>
                                <div class="dropdown-divider"></div>
                                <li type="button" data-bs-toggle="modal" data-bs-target="#exampleModal"><a class="dropdown-item" href="#">Import from link</a></li>
                            </ul>
                        </div>

                        <div class = "dropdown">
                            <button class = "btn btn-secondary dropdown-toggle" type = "button" id = "filterDropdown" data-bs-toggle="dropdown" aria-expanded="false">Filter</button>
                            <ul class = "dropdown-menu" aria-labelledby="filterDropdown">
                                <li><a class="dropdown-item" href="#" @click="dataAscSort()">By ID (ASC)</a></li>
                                <li><a class="dropdown-item" href="#" @click="dataDescSort()">By ID (DECS)</a></li>
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


        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
                <form @submit.prevent="submitForm()">
                    <div class="modal-body">
                        
                            <label for="validationCustom01" class="form-label">Link</label>
                            <input v-model="url" type="text" class="form-control" id="validationCustom01" placeholder = "https://epicentrk.ua/ua/shop/vesy-napolnye/" required>
                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button class="btn btn-primary" type="submit">Submit form</button>
                    </div>
                </form>
            </div>
        </div>
        </div>


</template>

<style scoped>

</style>
