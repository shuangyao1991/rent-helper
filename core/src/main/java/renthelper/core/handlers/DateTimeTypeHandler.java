package renthelper.core.handlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with by shuangyao on 2016/10/12.
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class DateTimeTypeHandler extends BaseTypeHandler<Date> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, format.format(parameter));
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseDate(rs.getString(columnName));
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseDate(rs.getString(columnIndex));
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseDate(cs.getString(columnIndex));
    }

    private Date parseDate(String s) {
        try {
            return format.parse(s);
        } catch (ParseException e) {
            logger.error("Parse datetime error.", e);
            return null;
        }
    }
}
