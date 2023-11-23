package airhacks.apigateway.control;

import software.amazon.awscdk.services.ec2.IpAddresses;
import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;

public class PrivateVPC extends Construct {

    Vpc vpc;

    public PrivateVPC(Construct scope) {
        super(scope, "PrivateVPC");
        this.vpc = Vpc.Builder.create(this, "PrivateVPC")
                .ipAddresses(IpAddresses.cidr("10.0.0.0/16"))
                .enableDnsHostnames(true)
                .enableDnsSupport(true)
                .natGateways(0)
                .createInternetGateway(false)
                .maxAzs(2)
                .build();
    }

    public Vpc getVpc(){
        return this.vpc;
    }

}
