package com.basho.riak.client.api.commands.kv;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.testng.annotations.Test;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakFuture;
import com.basho.riak.client.core.RiakNode;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.basho.riak.client.core.query.RiakObject;
import com.basho.riak.client.core.util.BinaryValue;

public class StoreValueTest{

    public static void main( String[] args ) throws InterruptedException{
        RiakNode.Builder builder = new RiakNode.Builder();
        builder.withMinConnections( 10 );
        builder.withMaxConnections( 50 );

        List< String > addresses = new LinkedList< String >();
        addresses.add( "192.168.1.158" );

        List< RiakNode > nodes = RiakNode.Builder.buildNodes( builder , addresses );
        RiakCluster cluster = new RiakCluster.Builder( nodes ).build();
        cluster.start();
        RiakClient client = new RiakClient( cluster );

        Namespace ns = new Namespace( "px-video-log" , "test1Replay20160318" );
        Location location = new Location( ns , "my_key2" );
        RiakObject riakObject = new RiakObject();
        riakObject.setValue( BinaryValue.create( "my_value2" ) );
        StoreValue store = new StoreValue.Builder( riakObject )
                .withLocation( location )
                .build();
        RiakFuture< StoreValue.Response, Location > future = client.executeAsync( store );
        future.await();
        System.out.println( future.isSuccess() );
        
        /*FetchValue fv = new FetchValue.Builder(location).build();
        RiakFuture< FetchValue.Response, Location > future = client.executeAsync( fv );
        future.await();
        if( future.isSuccess() ){
            FetchValue.Response response = future.get();
            RiakObject obj = response.getValue(RiakObject.class);
            System.out.println( obj.getValue().toString() );
        }*/
    }
}
