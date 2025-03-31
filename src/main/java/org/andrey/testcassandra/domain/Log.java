package org.andrey.testcassandra.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("logs")
public class Log {
    @Id
    private UUID id;
    @Column("log_level")
    private String logLevel;
    @Column("log_source")
    private String logSource;
}
