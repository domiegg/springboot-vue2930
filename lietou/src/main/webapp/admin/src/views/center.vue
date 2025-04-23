<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='bumenlingdao'"  label='部门领导姓名' prop="bumenlingdaoName">
               <el-input v-model="ruleForm.bumenlingdaoName"  placeholder='部门领导姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='bumenlingdao'"  label='部门领导手机号' prop="bumenlingdaoPhone">
               <el-input v-model="ruleForm.bumenlingdaoPhone"  placeholder='部门领导手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='bumenlingdao'"  label='部门领导身份证号' prop="bumenlingdaoIdNumber">
               <el-input v-model="ruleForm.bumenlingdaoIdNumber"  placeholder='部门领导身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='bumenlingdao'" label='部门领导头像' prop="bumenlingdaoPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.bumenlingdaoPhoto?ruleForm.bumenlingdaoPhoto:''"
                         @change="bumenlingdaoPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='bumenlingdao'"  label='部门' prop="bumenTypes">
                 <el-select v-model="ruleForm.bumenTypes" disabled  placeholder='请选择部门'>
                     <el-option
                             v-for="(item,index) in bumenTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='bumenlingdao'"  label='电子邮箱' prop="bumenlingdaoEmail">
               <el-input v-model="ruleForm.bumenlingdaoEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='bumenlingdao'"  label='籍贯' prop="jiguan">
               <el-input v-model="ruleForm.jiguan"  placeholder='籍贯' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='bumenlingdao'"  label='家庭住址' prop="bumenlingdaoZhuzhi">
               <el-input v-model="ruleForm.bumenlingdaoZhuzhi"  placeholder='家庭住址' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='caiwurenyuan'"  label='财务人员姓名' prop="caiwurenyuanName">
               <el-input v-model="ruleForm.caiwurenyuanName"  placeholder='财务人员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='caiwurenyuan'"  label='财务人员手机号' prop="caiwurenyuanPhone">
               <el-input v-model="ruleForm.caiwurenyuanPhone"  placeholder='财务人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='caiwurenyuan'"  label='财务人员身份证号' prop="caiwurenyuanIdNumber">
               <el-input v-model="ruleForm.caiwurenyuanIdNumber"  placeholder='财务人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='caiwurenyuan'" label='财务人员头像' prop="caiwurenyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.caiwurenyuanPhoto?ruleForm.caiwurenyuanPhoto:''"
                         @change="caiwurenyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='renshi'"  label='人事人员姓名' prop="renshiName">
               <el-input v-model="ruleForm.renshiName"  placeholder='人事人员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='renshi'"  label='人事人员手机号' prop="renshiPhone">
               <el-input v-model="ruleForm.renshiPhone"  placeholder='人事人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='renshi'"  label='人事人员身份证号' prop="renshiIdNumber">
               <el-input v-model="ruleForm.renshiIdNumber"  placeholder='人事人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='renshi'" label='人事人员头像' prop="renshiPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.renshiPhoto?ruleForm.renshiPhoto:''"
                         @change="renshiPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yuangong'"  label='普通员工姓名' prop="yuangongName">
               <el-input v-model="ruleForm.yuangongName"  placeholder='普通员工姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yuangong'"  label='普通员工手机号' prop="yuangongPhone">
               <el-input v-model="ruleForm.yuangongPhone"  placeholder='普通员工手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yuangong'"  label='普通员工身份证号' prop="yuangongIdNumber">
               <el-input v-model="ruleForm.yuangongIdNumber"  placeholder='普通员工身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yuangong'" label='普通员工头像' prop="yuangongPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yuangongPhoto?ruleForm.yuangongPhoto:''"
                         @change="yuangongPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yuangong'" disabled label='部门' prop="bumenTypes">
                 <el-select v-model="ruleForm.bumenTypes" disabled placeholder='请选择部门'>
                     <el-option
                             v-for="(item,index) in bumenTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yuangong'"  label='电子邮箱' prop="yuangongEmail">
               <el-input v-model="ruleForm.yuangongEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yuangong'"  label='籍贯' prop="jiguan">
               <el-input v-model="ruleForm.jiguan"  placeholder='籍贯' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yuangong'"  label='家庭住址' prop="yuangongZhuzhi">
               <el-input v-model="ruleForm.yuangongZhuzhi"  placeholder='家庭住址' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      sexTypesOptions : [],
     bumenTypesOptions : [],
     bumenTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
          this.sexTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
  });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=bumen_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.bumenTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=bumen_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.bumenTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    bumenlingdaoPhotoUploadChange(fileUrls) {
        this.ruleForm.bumenlingdaoPhoto = fileUrls;
    },
    caiwurenyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.caiwurenyuanPhoto = fileUrls;
    },
    renshiPhotoUploadChange(fileUrls) {
        this.ruleForm.renshiPhoto = fileUrls;
    },
    yuangongPhotoUploadChange(fileUrls) {
        this.ruleForm.yuangongPhoto = fileUrls;
    },

    onUpdateHandler() {
                         if((!this.ruleForm.bumenlingdaoName)&& 'bumenlingdao'==this.flag){
                             this.$message.error('部门领导姓名不能为空');
                             return
                         }

                             if( 'bumenlingdao' ==this.flag && this.ruleForm.bumenlingdaoPhone&&(!isMobile(this.ruleForm.bumenlingdaoPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.bumenlingdaoIdNumber)&& 'bumenlingdao'==this.flag){
                             this.$message.error('部门领导身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.bumenlingdaoPhoto)&& 'bumenlingdao'==this.flag){
                             this.$message.error('部门领导头像不能为空');
                             return
                         }

                         if((!this.ruleForm.bumenTypes)&& 'bumenlingdao'==this.flag){
                             this.$message.error('部门不能为空');
                             return
                         }

                             if( 'bumenlingdao' ==this.flag && this.ruleForm.bumenlingdaoEmail&&(!isEmail(this.ruleForm.bumenlingdaoEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.jiguan)&& 'bumenlingdao'==this.flag){
                             this.$message.error('籍贯不能为空');
                             return
                         }

                         if((!this.ruleForm.bumenlingdaoZhuzhi)&& 'bumenlingdao'==this.flag){
                             this.$message.error('家庭住址不能为空');
                             return
                         }

                         if((!this.ruleForm.caiwurenyuanName)&& 'caiwurenyuan'==this.flag){
                             this.$message.error('财务人员姓名不能为空');
                             return
                         }

                             if( 'caiwurenyuan' ==this.flag && this.ruleForm.caiwurenyuanPhone&&(!isMobile(this.ruleForm.caiwurenyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.caiwurenyuanIdNumber)&& 'caiwurenyuan'==this.flag){
                             this.$message.error('财务人员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.caiwurenyuanPhoto)&& 'caiwurenyuan'==this.flag){
                             this.$message.error('财务人员头像不能为空');
                             return
                         }

                         if((!this.ruleForm.renshiName)&& 'renshi'==this.flag){
                             this.$message.error('人事人员姓名不能为空');
                             return
                         }

                             if( 'renshi' ==this.flag && this.ruleForm.renshiPhone&&(!isMobile(this.ruleForm.renshiPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.renshiIdNumber)&& 'renshi'==this.flag){
                             this.$message.error('人事人员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.renshiPhoto)&& 'renshi'==this.flag){
                             this.$message.error('人事人员头像不能为空');
                             return
                         }

                         if((!this.ruleForm.yuangongName)&& 'yuangong'==this.flag){
                             this.$message.error('普通员工姓名不能为空');
                             return
                         }

                             if( 'yuangong' ==this.flag && this.ruleForm.yuangongPhone&&(!isMobile(this.ruleForm.yuangongPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yuangongIdNumber)&& 'yuangong'==this.flag){
                             this.$message.error('普通员工身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yuangongPhoto)&& 'yuangong'==this.flag){
                             this.$message.error('普通员工头像不能为空');
                             return
                         }

                         if((!this.ruleForm.bumenTypes)&& 'yuangong'==this.flag){
                             this.$message.error('部门不能为空');
                             return
                         }

                             if( 'yuangong' ==this.flag && this.ruleForm.yuangongEmail&&(!isEmail(this.ruleForm.yuangongEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.jiguan)&& 'yuangong'==this.flag){
                             this.$message.error('籍贯不能为空');
                             return
                         }

                         if((!this.ruleForm.yuangongZhuzhi)&& 'yuangong'==this.flag){
                             this.$message.error('家庭住址不能为空');
                             return
                         }

        if((!this.ruleForm.sexTypes) && this.flag!='users'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
