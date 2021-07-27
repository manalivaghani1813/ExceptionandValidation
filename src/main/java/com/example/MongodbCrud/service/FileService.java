package com.example.MongodbCrud.service;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public boolean upload(MultipartFile file) {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIASMU3SKYLFVGY5F4L", "4r1a1KUiYITilGq5B5FxRBnTrxuWm2RFdVQvR8Ra");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();
        try {
            ObjectMetadata metaData = new ObjectMetadata();
            metaData.setContentLength(file.getSize());
            metaData.setContentType(file.getContentType());
            s3.putObject("fileaccessapi", file.getOriginalFilename(), file.getInputStream(), metaData);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public S3Object getFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIASMU3SKYLFVGY5F4L", "4r1a1KUiYITilGq5B5FxRBnTrxuWm2RFdVQvR8Ra");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();

        return s3.getObject("fileaccessapi", key);

    }

    public void deleteObject(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIASMU3SKYLFVGY5F4L", "4r1a1KUiYITilGq5B5FxRBnTrxuWm2RFdVQvR8Ra");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();

        System.out.println("Deleted the object "+s3);
        s3.deleteObject("fileaccessapi",key);

    }


}
