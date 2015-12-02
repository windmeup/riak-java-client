package com.basho.riak.client.core.query.timeseries.wrappedpb;

import com.basho.riak.client.core.query.timeseries.ICell;
import com.basho.riak.client.core.util.BinaryValue;
import com.basho.riak.protobuf.RiakTsPB;

/**
 * @author Sergey Galkin <srggal at gmail dot com>
 * @since 2.0.3
 */
public class PbCell implements ICell
{
    private final RiakTsPB.TsCell pbCell;

    public PbCell(RiakTsPB.TsCell pbCell)
    {
        this.pbCell = pbCell;
    }

    @Override
    public boolean hasVarcharValue()
    {
        return pbCell.hasVarcharValue();
    }

    @Override
    public boolean hasLong()
    {
        return pbCell.hasSint64Value();
    }

    @Override
    public boolean hasTimestamp()
    {
        return pbCell.hasTimestampValue();
    }

    @Override
    public boolean hasBoolean()
    {
        return pbCell.hasBooleanValue();
    }

    @Override
    public boolean hasDouble()
    {
        return pbCell.hasDoubleValue();
    }

    @Override
    public String getVarcharAsUTF8String()
    {
        return pbCell.getVarcharValue().toStringUtf8();
    }

    @Override
    public BinaryValue getVarcharValue()
    {
        return BinaryValue.unsafeCreate(pbCell.getVarcharValue().toByteArray());
    }

    @Override
    public long getLong()
    {
        return pbCell.getSint64Value();
    }

    @Override
    public double getDouble()
    {
        return pbCell.getDoubleValue();
    }

    @Override
    public long getTimestamp()
    {
        return pbCell.getTimestampValue();
    }

    @Override
    public boolean getBoolean()
    {
        return pbCell.getBooleanValue();
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Cell{ ");

        if (this.hasVarcharValue())
        {
            final String value = this.getVarcharAsUTF8String();
            if (value.length() > 32)
            {
                sb.append(value.substring(0,32));
                sb.append("...");
            }
            else
            {
                sb.append(value);
            }
        }
        else if (this.hasLong())
        {
            sb.append(this.getLong());
        }
        else if (this.hasDouble())
        {
            sb.append(this.getDouble());
        }
        else if (this.hasTimestamp())
        {
            sb.append(this.getTimestamp());
        }
        else if (this.hasBoolean())
        {
            sb.append(this.getBoolean());
        }

        sb.append(" }");
        return sb.toString();
    }
}
