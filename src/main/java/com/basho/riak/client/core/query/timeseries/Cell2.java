package com.basho.riak.client.core.query.timeseries;

import com.basho.riak.client.core.query.timeseries.wrappedpb.PbCell;
import com.basho.riak.client.core.util.BinaryValue;
import com.basho.riak.protobuf.RiakTsPB;
import com.google.protobuf.ByteString;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by alex on 12/1/15.
 */
public final class Cell2
{
    public static ICell New(String value)
    {
        final RiakTsPB.TsCell tsCell =
                RiakTsPB.TsCell.newBuilder().setVarcharValue(ByteString.copyFromUtf8(value)).build();
        return new PbCell(tsCell);
    }

    public static ICell New(BinaryValue value)
    {
        final RiakTsPB.TsCell tsCell =
                RiakTsPB.TsCell.newBuilder().setVarcharValue(ByteString.copyFrom(value.unsafeGetValue())).build();
        return new PbCell(tsCell);
    }

    public static ICell New(long value)
    {
        final RiakTsPB.TsCell tsCell =
                RiakTsPB.TsCell.newBuilder().setSint64Value(value).build();
        return new PbCell(tsCell);
    }

    public static ICell New(double value)
    {
        final RiakTsPB.TsCell tsCell =
                RiakTsPB.TsCell.newBuilder().setDoubleValue(value).build();
        return new PbCell(tsCell);
    }

    public static ICell New(boolean value)
    {
        final RiakTsPB.TsCell tsCell =
                RiakTsPB.TsCell.newBuilder().setBooleanValue(value).build();
        return new PbCell(tsCell);
    }

    public static ICell New(Calendar value)
    {
        final RiakTsPB.TsCell tsCell =
                RiakTsPB.TsCell.newBuilder().setTimestampValue(value.getTimeInMillis()).build();
        return new PbCell(tsCell);
    }

    public static ICell New(Date value)
    {
        final RiakTsPB.TsCell tsCell =
                RiakTsPB.TsCell.newBuilder().setTimestampValue(value.getTime()).build();
        return new PbCell(tsCell);
    }

    public static ICell NewTimestamp(long value)
    {
        final RiakTsPB.TsCell tsCell =
                RiakTsPB.TsCell.newBuilder().setTimestampValue(value).build();
        return new PbCell(tsCell);
    }
 }
