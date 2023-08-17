package com.example.demoextension;

import net.devh.boot.grpc.server.service.GrpcService;
import proto.extension.carthooks.com.*;
import io.grpc.stub.StreamObserver;

@GrpcService
public class DemoExtensionService extends CarthooksExtensionGrpc.CarthooksExtensionImplBase {

    @Override
    public void info(Empty request, StreamObserver<InfoResponse> responseObserver) {
        InfoResponse rsp = InfoResponse.newBuilder().setAuthor("demo").build();
        responseObserver.onNext(rsp);
        responseObserver.onCompleted();
    }


    @Override
    public void getCustomFieldTypes(Empty request, StreamObserver<GetFieldsResponse> responseObserver) {
        GetFieldsResponse rsp = GetFieldsResponse.newBuilder()
                .addFields(
                        CustomFieldType.newBuilder()
                                .setName("iot")
                                .setInputComponent(Assets.newBuilder().setPath("IotInput").build())
                                .setSettingComponent(Assets.newBuilder().setPath("IotSetting").build())
                                .setType(StorageType.STORAGE_NUMBER).build()
                ).build();

        responseObserver.onNext(rsp);
        responseObserver.onCompleted();
    }

    /**
     */
    @Override
    public void getServices(Empty request, StreamObserver<GetServicesResponse> responseObserver) {
        GetServicesResponse rsp = GetServicesResponse.newBuilder()
                        .addServices(
                                Service.newBuilder()
                                    .setName(I18nString.newBuilder().setDefault("test service").build())
                                    .build()
                        ).build();

        responseObserver.onNext(rsp);
        responseObserver.onCompleted();
    }

    /**
     */
    @Override
    public void getConnectors(Empty request, StreamObserver<GetConnectorsResponse> responseObserver) {
        GetConnectorsResponse rsp = GetConnectorsResponse.newBuilder().build();

        responseObserver.onNext(rsp);
        responseObserver.onCompleted();
    }


}